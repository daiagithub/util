package org.daia.util.rest

import groovy.json.JsonBuilder;
import groovy.json.JsonOutput;
import groovy.json.JsonSlurper;

import java.net.HttpURLConnection;

class RestClientTest {

	static main(args) {
		def token = startLoginSession()
		println token
		//[{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":0,"persistenceVersion_string":"0","employeeId":"343","employeeName":"natesh","department":"Administration","designation":"Senior Service Administrator","grade":"A1","reportingManager":"vara","reportingManagerEmail":"vara@gmail.co","employmentType":"Permanent","dateOfJoining":1451606400000,"dateOfRelieving":1452038400000,"resignation":{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":3,"persistenceVersion_string":"3","caseId":2,"caseId_string":"2","caseInitiationDate":1452692581934,"dateOfResignation":1451952000000,"reasonForLeaving":"Resignation","noticePeriod":null,"allDeptStatus":null,"initiator":null,"checklist":[{"persistenceId":4,"persistenceId_string":"4","persistenceVersion":0,"persistenceVersion_string":"0","type":"IT","checkListItem":"Bond Amounts","status":"Done"},{"persistenceId":5,"persistenceId_string":"5","persistenceVersion":0,"persistenceVersion_string":"0","type":"ACCOUNTS","checkListItem":"Bond Amounts","status":"Done"},{"persistenceId":6,"persistenceId_string":"6","persistenceVersion":0,"persistenceVersion_string":"0","type":"HR","checkListItem":"Travel Settlements","status":"Done"}],"clearance":[{"persistenceId":4,"persistenceId_string":"4","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"comments","remarks":"Approve","signature":"","department":"IT"},{"persistenceId":5,"persistenceId_string":"5","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"account clearence","remarks":"Approve","signature":"","department":"ACCOUNTS"},{"persistenceId":6,"persistenceId_string":"6","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"approving the form","remarks":"Approve","signature":"","department":"HR"}]}},{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":0,"persistenceVersion_string":"0","employeeId":"","employeeName":"","department":"","designation":"","grade":"","reportingManager":"","reportingManagerEmail":"","employmentType":"","dateOfJoining":1451692800000,"dateOfRelieving":1454198400000,"resignation":{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":3,"persistenceVersion_string":"3","caseId":1,"caseId_string":"1","caseInitiationDate":1452692188056,"dateOfResignation":1453939200000,"reasonForLeaving":"","noticePeriod":null,"allDeptStatus":null,"initiator":null,"checklist":[{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":0,"persistenceVersion_string":"0","type":"ACCOUNTS","checkListItem":"Travel Settlements","status":""},{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":0,"persistenceVersion_string":"0","type":"IT","checkListItem":"Travel Settlements","status":""},{"persistenceId":3,"persistenceId_string":"3","persistenceVersion":0,"persistenceVersion_string":"0","type":"HR","checkListItem":"Bond Amounts","status":""}],"clearance":[{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"xx","remarks":"On-Hold","signature":"","department":"ACCOUNTS"},{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"c","remarks":"Approve","signature":"","department":"IT"},{"persistenceId":3,"persistenceId_string":"3","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"cc","remarks":"Approve","signature":"","department":"HR"}]}}]

		def resp = getAllOffboardingDetails(token);
		//def resp = '[{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":0,"persistenceVersion_string":"0","employeeId":"343","employeeName":"natesh","department":"Administration","designation":"Senior Service Administrator","grade":"A1","reportingManager":"vara","reportingManagerEmail":"vara@gmail.co","employmentType":"Permanent","dateOfJoining":1451606400000,"dateOfRelieving":1452038400000,"resignation":{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":3,"persistenceVersion_string":"3","caseId":2,"caseId_string":"2","caseInitiationDate":1452692581934,"dateOfResignation":1451952000000,"reasonForLeaving":"Resignation","noticePeriod":null,"allDeptStatus":null,"initiator":null,"checklist":[{"persistenceId":4,"persistenceId_string":"4","persistenceVersion":0,"persistenceVersion_string":"0","type":"IT","checkListItem":"Bond Amounts","status":"Done"},{"persistenceId":5,"persistenceId_string":"5","persistenceVersion":0,"persistenceVersion_string":"0","type":"ACCOUNTS","checkListItem":"Bond Amounts","status":"Done"},{"persistenceId":6,"persistenceId_string":"6","persistenceVersion":0,"persistenceVersion_string":"0","type":"HR","checkListItem":"Travel Settlements","status":"Done"}],"clearance":[{"persistenceId":4,"persistenceId_string":"4","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"comments","remarks":"Approve","signature":"","department":"IT"},{"persistenceId":5,"persistenceId_string":"5","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"account clearence","remarks":"Approve","signature":"","department":"ACCOUNTS"},{"persistenceId":6,"persistenceId_string":"6","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"approving the form","remarks":"Approve","signature":"","department":"HR"}]}},{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":0,"persistenceVersion_string":"0","employeeId":"","employeeName":"","department":"","designation":"","grade":"","reportingManager":"","reportingManagerEmail":"","employmentType":"","dateOfJoining":1451692800000,"dateOfRelieving":1454198400000,"resignation":{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":3,"persistenceVersion_string":"3","caseId":1,"caseId_string":"1","caseInitiationDate":1452692188056,"dateOfResignation":1453939200000,"reasonForLeaving":"","noticePeriod":null,"allDeptStatus":null,"initiator":null,"checklist":[{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":0,"persistenceVersion_string":"0","type":"ACCOUNTS","checkListItem":"Travel Settlements","status":""},{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":0,"persistenceVersion_string":"0","type":"IT","checkListItem":"Travel Settlements","status":""},{"persistenceId":3,"persistenceId_string":"3","persistenceVersion":0,"persistenceVersion_string":"0","type":"HR","checkListItem":"Bond Amounts","status":""}],"clearance":[{"persistenceId":1,"persistenceId_string":"1","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"xx","remarks":"On-Hold","signature":"","department":"ACCOUNTS"},{"persistenceId":2,"persistenceId_string":"2","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"c","remarks":"Approve","signature":"","department":"IT"},{"persistenceId":3,"persistenceId_string":"3","persistenceVersion":0,"persistenceVersion_string":"0","deptStatus":"cc","remarks":"Approve","signature":"","department":"HR"}]}}]'
		def slurper = new JsonSlurper()
		def result = slurper.parseText(resp)
		result.each{offboarding->
			offboarding.resignation.clearance={
				def clearance = ""
				offboarding.resignation.clearance.each{
					clearance += it.department + ": " + it.deptStatus + " "
				}
				return clearance
			}()
		}
		println JsonOutput.toJson(result)
	}

	private static String startLoginSession(){
		def jsonString = doPost(null, null, null)
		def slurper = new JsonSlurper()
		def result = slurper.parseText(jsonString)
		return result.responseHeaders["Set-Cookie"]
	}

	private static doPost(url, params, contentType){
		HttpURLConnection connection = null;
		def responseCode = null;
		def responseBody = null;
		def headers;
		
		try {
			url = new URL("http://localhost:8080/bonita/loginservice");//TODO
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			params = ["username": "mark", "password": "bpm", "redirect": false]
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			connection.setDoOutput(true);
			connection.getOutputStream().write(postDataBytes);

			responseCode = connection.getResponseCode();

			if(responseCode == 200 || responseCode == 201){
				responseBody = getResponseBody(connection.getInputStream());
			} else if(responseCode != 204){
				responseBody = getResponseBody(connection.getErrorStream());
			}

			headers = connection.getHeaderFields()
			
			
		} catch (Exception e) {
			if(connection != null && connection.getErrorStream() != null){
				try {
					responseBody = getResponseBody(connection.getErrorStream());
				} catch (Exception e1) {
					println ("Exception Message:"+ e.getMessage());
				}
			} else {
				responseBody = e.getMessage();
			}
			println ("Error code: "+responseCode);
			println ("Reason for REST API Call error: " + responseBody);
		}finally {
			if (connection != null)	connection.disconnect();
		}	
		return buildResponse(responseCode, headers, responseBody) 
	}

	/**
	 * Parse out the text from the InputStream parameter
	 * @param stream
	 * @return
	 * @throws Exception
	 */
	private static String getResponseBody(InputStream stream) throws Exception {
		String responseBody = "";
		BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
		String inputLine;
		while ((inputLine = buffer.readLine()) != null) {
			responseBody += inputLine;
		}
		buffer.close();
		return responseBody;
	}
	
	private static buildResponse(code, headers, body){
		def finalHeaders = [:]
		for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
			if(entry.getKey() != null)
				finalHeaders.put(entry.getKey(), entry.getValue())
			else
				finalHeaders.put("null", entry.getValue())			
		}
		
		def json = new JsonBuilder()
		def root = json {
			responseCode code ?: ""
			responseHeaders finalHeaders
			responseBody body ?: ""			
		}
		
		return json.toPrettyString()
	}


	protected static String getAllOffboardingDetails(token){
		URL url = new URL("http://localhost:8080/bonita/API/bdm/businessData/com.evoke.offboarding.Employee?q=findAll&p=0&c=10");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Cookie", token);
		String responseBody = getResponseBody(connection.getInputStream())
		connection.disconnect();
		println responseBody
		return responseBody

	}
}
