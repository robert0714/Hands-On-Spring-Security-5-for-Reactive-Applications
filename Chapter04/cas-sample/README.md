
# CAS server and secured client setup  
## Exporting the .crt file to Java and the JRE  cacert  
keytool -import -alias thekeystore -storepass password -file thekeystore.crt -keystore "$JAVA_HOME/jre/lib/security/cacerts"

## CAS Server  
<img src="../screenshots/1.1.png" alt="" align="center">  
  
<img src="../screenshots/1.2.png" alt="" align="center">  

<img src="../screenshots/1.3.png" alt="" align="center">  
  
<img src="../screenshots/1.4.png" alt="" align="center">  

<img src="../screenshots/1.5.png" alt="" align="center">  

<img src="../screenshots/1.6.png" alt="" align="center">  

<img src="../screenshots/1.7.png" alt="" align="center">  

<img src="../screenshots/1.8.png" alt="" align="center">  

<img src="../screenshots/1.9.png" alt="" align="center">  

## Secured CAS client  
<img src="../screenshots/2.1.png" alt="" align="center">  

<img src="../screenshots/2.2.png" alt="" align="center">  

<img src="../screenshots/2.3.png" alt="" align="center">  

<img src="../screenshots/2.4.png" alt="" align="center">  

<img src="../screenshots/2.5.png" alt="" align="center">  
>>>>>>> branch 'master' of https://github.com/robert0714/Hands-On-Spring-Security-5-for-Reactive-Applications.git
