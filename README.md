# Dynatrace::Installer::Agent

Dynatrace Installer resource currently supports OneAgent installation for Linux systems, but it's fully extensible. 
You can build the resource from the source code using Java environment (cfn-cli tool/RPDK, Maven, JDK, git CLI, etc) with the following steps:

Clone git repository - ```git clone https://github.com/mnalezin/DynatraceInstallerAgent```
Create package with Maven - ```mvn package```
Submit the resource - ```cfn-cli submit```

Feel free to experiment with the new resource provider and contact us with questions and comments.
