<h1>JAVA OPEN API client </h1>
<br>
<p>
    This is a simple JAVA client which interact with OPEN API.
    In this sample, it makes a call to Diagnostic Tool OPEN API - List Available Ghost locations - https://developer.akamai.com/api/core_features/diagnostic_tools/v2.html#getghostavailable.
    It's open for modification
</p>
<br>
<h3>Pre-requisite</h3>
<ul>
    <li>Java installed in the loca 
    (note: I use JAVA 12 in this sample, but if you have different JAVA version locally, change the "properties" tag in pom.xml</properties></li>
    <li>Maven installed in local</li>
</ul>
<br>
<h3>To run the client:</h3>
<ul>
    <li>Clone this project - $git clone https://github.com/Senopratomo/Java-OPEN-API.git</li>
    <li>Go to that root dir of the project - $cd Java-OPEN-API</li>
    <li>Open src\main\java\org\senolab\openapijavasample\Main.java and update the variable to the value associated with your OPEN API client:
        <ul>
            <li>clientToken</li>
            <li>accessToken</li>
            <li>clientSecret</li>
            <li>host</li>
        </ul>
    </li> 
    <li>Run Maven install - $mvn clean install</li>
    <li>Execute the jar - $java -jar target\openapijavasample-1.0-SNAPSHOT-jar-with-dependencies.jar</li>
    <li>Enjoy!</li>
</ul>