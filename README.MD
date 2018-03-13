### Demo project for Zeropark

### Run at Jenkins: 
http://jenkins-liashenko.eastus.cloudapp.azure.com

##### To run locally:
`git clone -b local-webDriver https://github.com/YarLyashenko/zeropark.git`

`mvn clean install `

###### You could specify additional parameters:

To run only API tests: `mvn clean install -Dgroups=zeropark.api.ApiTests` 

To run only UI tests: `mvn clean install -Dgroups=zeropark.ui.UiTests`

To run only UI tests in chrome: `mvn clean install -Dgroups=zeropark.ui.UiTests -DbrowserName=chrome`

To run only UI tests in firefox: `mvn clean install -Dgroups=zeropark.ui.UiTests -DbrowserName=firefox` 