package com.qa.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.TestBase;

public class MyListener extends TestBase implements ITestListener, WebDriverListener{

	
	
//	@Override
//	public void beforeGet(WebDriver driver, String url) {
//		System.out.println("Before navigating to: '"+url+"'");
//	}
//
//	@Override
//	public void afterGet(WebDriver driver, String url) {
//		System.out.println("After navigating to: '"+url+"'");
//	}
//
//	@Override
//	public void beforeClick(WebElement element) {
//		System.out.println("Before clicking on element: '"+element+"'");
//	}
//	
//	@Override
//	public void afterClick(WebElement element) {
//		System.out.println("After clicking on element: '"+element+"'");
//	}
//
//	@Override
//	public void beforeForward(Navigation navigation) {
//		System.out.println("Navigating forward to next page");
//	}
//
//	@Override
//	public void afterForward(Navigation navigation) {
//		System.out.println("Navigated forward to next page");
//	}
//
//	@Override
//	public void beforeBack(Navigation navigation) {
//		System.out.println("Navigating back to the last page");
//	}
//
//	@Override
//	public void afterBack(Navigation navigation) {
//		System.out.println("Navigated back to the last page");
//	}
//
//	@Override
//	public void beforeFindElement(WebDriver driver, By locator) {
//		System.out.println("Trying to find the element: " +locator.toString());
//	}
//
//	@Override
//	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//		System.out.println("Found the element: " +locator.toString());
//	}
//	
//	@Override
//	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
//		System.out.println("Error Occured: " +e.getMessage());
//		try {
//			TestUtil.TakeScreenShotWhenFailed(method.getName());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test has started: " +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test got success: " +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test got failed: " +result.getName());
		try {
			TestUtil.TakeScreenShotWhenFailed(result.getName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped: " +result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	
	
	
	
	
	

}
