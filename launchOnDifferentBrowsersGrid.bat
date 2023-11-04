start java -jar selenium-server-4.14.1.jar hub --config configurationOptionsBrowsersGrid.toml
start java -jar selenium-server-4.14.1.jar node  --port 5555 --config configurationOptionsBrowsersGrid.toml
start java -jar selenium-server-4.14.1.jar node  --port 6666 --config configurationOptionsBrowsersGrid.toml
start mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testrunner/testng_browsers_grid.xml