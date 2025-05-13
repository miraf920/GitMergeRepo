package MCompleteSeleniumFramework.TestsComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MRetry implements IRetryAnalyzer {
	
	int count =0;
	int maxretry =1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxretry) {
			count++;
			result.setStatus(result.SKIP);
			return true;
		}
		return false;
	}
	
	
	
	

}
