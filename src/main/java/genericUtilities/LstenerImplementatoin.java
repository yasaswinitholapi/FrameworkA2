package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LstenerImplementatoin implements ITestListener{
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite excution starts");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"Execution Starts");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"Fail");
		System.out.println("Faled due to: "+result.getThrowable());
		WebdriverUtilty web=new WebdriverUtilty();
	web.captureScreenshot(Baseclass.sdriver, result.getMethod().getMethodName(), Baseclass.sjutil);
	//System.out.println("skipped due to :"+result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"skipped");
		System.out.println("skipped due to :"+result.getThrowable());
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution terminates");
	}

	
}
