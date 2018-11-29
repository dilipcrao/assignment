$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/dvlasearch.feature");
formatter.feature({
  "line": 1,
  "name": "As a web user",
  "description": "",
  "id": "as-a-web-user",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Search the dvla website for reg numbers",
  "description": "",
  "id": "as-a-web-user;search-the-dvla-website-for-reg-numbers",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am a web user",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I navigate to dvla website",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I provide the registration number of a vehicle from a csv file",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I should be able to verify the details of the vehicle as present in the csv file",
  "keyword": "Then "
});
formatter.match({
  "location": "DVLASearchStepDef.iAmAWebUser()"
});
formatter.result({
  "duration": 5144957266,
  "status": "passed"
});
formatter.match({
  "location": "DVLASearchStepDef.iNavigateToDvlaWebsite()"
});
formatter.result({
  "duration": 2686987300,
  "status": "passed"
});
formatter.match({
  "location": "DVLASearchStepDef.iProvideTheRegistrationNumberOfAVehicleFromACsvFile()"
});
formatter.result({
  "duration": 11330704694,
  "status": "passed"
});
formatter.match({
  "location": "DVLASearchStepDef.iShouldBeAbleToVerifyTheDetailsOfTheVehicleAsPresentInTheCsvFile()"
});
formatter.result({
  "duration": 692741985,
  "status": "passed"
});
});