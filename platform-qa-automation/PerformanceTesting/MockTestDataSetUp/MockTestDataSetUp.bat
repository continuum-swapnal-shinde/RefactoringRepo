xcopy /s /q /i C:\MockDataPFTest\MockTestDataReport C:\MockDataPFTest\Reports\MockTestDataReport%DATE:~0,2%%DATE:~3,2%%DATE:~6,4%%TIME:~0,2%%TIME:~3,2%
@rd /s /q "C:\MockDataPFTest\MockTestDataReport"
del C:\MockDataPFTest\PerformanceTestLogFile.jtl
cd C:\apache-jmeter-3.1\apache-jmeter-3.1\bin
jmeter -Jcsvfile=C:\MockDataPFTest\MockTestDataForAttributes.csv -n -t C:\MockDataPFTest\MockDataSetUpTestPlan.jmx -JUSERS=65 -l C:\MockDataPFTest\PerformanceTestLogFile.jtl -e -o C:\MockDataPFTest\MockTestDataReport\ 





