# allure-reporting

This Project is integration of Maven, Testng and Allure reporting

Instructions:

1. Download Maven from https://maven.apache.org/download.cgi (Download tarball file and install it, For Installation instructions follow this site https://www.mkyong.com/maven/install-maven-on-mac-osx/)
2. Run the tests mvn clean test
3. Surefire-plugin runs all tests that matches with filename pattern such as *Test.java in test source directory src/test/java . To use a different naming scheme, we can configure Surefire Plugin which includes parameter and specify the tests that we want to include. 

