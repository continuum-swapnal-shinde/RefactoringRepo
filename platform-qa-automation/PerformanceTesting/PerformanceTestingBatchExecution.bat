@echo off
@rd /s /q "C:\PerformanceTesting\PerformanceAutomation"
del C:\PerformanceTesting\PerformanceTestLogFile.jtl
cd C:\apache-jmeter-3.1\apache-jmeter-3.1\bin
jmeter -n -t C:\PerformanceTesting\JUNOPerformanceTestSuite.jmx -l C:\PerformanceTesting\PerformanceTestLogFile.jtl -e -o C:\PerformanceTesting\PerformanceAutomation\ 
pause

