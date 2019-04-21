package com.yash.manager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.CucumberTagStatement;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;

public class RunManager {

	static Map<String, List<String>> featureMap;

	/**
	 * create runtime option and runs all features
	 * 
	 * @param argv
	 * @param classLoader
	 * @return
	 * @throws Exception
	 */
	public static void runner(ClassLoader classLoader) throws Exception {

		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy-HH-mm-SS");

		String d = ft.format(new Date()).replace("-", "_");

		String plugin = "com.cucumber.listener.ExtentCucumberFormatter:output/Report_" + d + "/Report.html";

                
		try {
			featureMap = RunManager.getFeaturesToRun("RunManager/RunManager.xlsx");
		} catch (Exception e) {
			System.out.println("********** Failed to load Run Manager File *************");
			e.printStackTrace();
		}

		for (String feature : featureMap.keySet()) {

			List<String> arg = new ArrayList<String>();

			arg.add("--plugin");
			arg.add(plugin);
			arg.add("--glue");
			arg.add("com.yash.testPackage");
			arg.add("Features/" + featureMap.get(feature).get(0) + ".feature");
            
			System.out.println("Set Glue as: " + "com.yash.TestPackage" );
			System.out.println("Running Feature File : " + "Features/" + featureMap.get(feature).get(0) + ".feature");

			if (!featureMap.get(feature).get(1).isEmpty()) { // check if tags are given or not
				arg.add("--tags");
				arg.add(featureMap.get(feature).get(1));
				System.out.println("Set tags as :" + featureMap.get(feature).get(1));
			}

			RuntimeOptions runtimeOptions = new RuntimeOptions(arg);

			ResourceLoader resourceLoader = new MultiLoader(classLoader);
			ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
			Runtime runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
			// runtime.run(); // runs cucumber feature inside
			// cucumber.runtime.Runtime

			runFeatureFile(runtime, runtimeOptions, resourceLoader, classLoader);

		}
		// return runtime.exitStatus();
	}

	/**
	 * Runs Feature file
	 * 
	 * @param runtime
	 * @param runtimeOptions
	 * @param resourceLoader
	 * @param classLoader
	 * @throws IOException
	 */
	private static void runFeatureFile(Runtime runtime, RuntimeOptions runtimeOptions, ResourceLoader resourceLoader,
			ClassLoader classLoader) throws IOException {
		// Make sure all features parse before initialising any
		// reporters/formatters
		List<CucumberFeature> features = runtimeOptions.cucumberFeatures(resourceLoader);

		Formatter formatter = runtimeOptions.formatter(classLoader);
		Reporter reporter = runtimeOptions.reporter(classLoader);

		for (CucumberFeature cucumberFeature : features) {
			System.out.println("********* Runing Feature : " + cucumberFeature.getGherkinFeature().getName() + " **********");
			
			runfeature(cucumberFeature, formatter, reporter, runtime);
			
		}

		formatter.done();
		formatter.close();
		runtime.printSummary();
		
	}

	/**
	 * Runs a feature
	 * 
	 * @param formatter
	 * @param reporter
	 * @param runtime
	 */
	private static void runfeature(CucumberFeature cf, Formatter formatter, Reporter reporter, Runtime runtime) {
		formatter.uri(cf.getPath());
		formatter.feature(cf.getGherkinFeature());

		for (CucumberTagStatement cucumberTagStatement : cf.getFeatureElements()) {
			// Run the scenario, it should handle before and after hooks
			System.out.println("Runing Scenario : " + cucumberTagStatement.getVisualName());
			cucumberTagStatement.run(formatter, reporter, runtime);
		}
		formatter.eof();

	}

	public static Map<String, List<String>> getFeaturesToRun(String fileName) throws Exception {
		
		Map<String, List<String>> featureMap = new HashMap<String, List<String>>();
			Workbook workbook = WorkbookFactory.create(new File(fileName));
			Sheet sheet = workbook.getSheet("Sheet1");

			int nRows = sheet.getLastRowNum();
		//	int nCols = sheet.getRow(0).getLastCellNum();
		//	Row secondRow = sheet.getRow(1);

			for (int r = 1; r <= nRows; r++) {
				
				Row row = sheet.getRow(r);
				if(row.getCell(1).getStringCellValue().equalsIgnoreCase("Y")){
					String featureName;
					List<String>featureData = new ArrayList<String>();
					featureName = row.getCell(0).getStringCellValue();        // read feature name
//					if(!(row.getCell(3).getStringCellValue().isEmpty() || null == row.getCell(3).getStringCellValue())){
					
						featureData.add(row.getCell(2).getStringCellValue()); // read feature file path
						featureData.add(row.getCell(3).getStringCellValue());  // read tags
					
//					}
					featureMap.put(featureName, featureData);
				}
			}
			workbook.close();
			return featureMap;
	}

}
