# Dynatrace::Installer::Agent

Dynatrace Installer resource currently supports OneAgent installation for Linux systems, but it's fully extensible. 
You can build the resource from the source code using Java environment (cfn-cli tool/RPDK, Maven, JDK, git CLI, etc) with the following steps:

1. Clone git repository - ```git clone https://github.com/mnalezin/DynatraceInstallerAgent```
1. cd DynatraceInstallerAgent/
1. Create package with Maven - ```mvn package```
1. Submit the resource - ```cfn-cli submit```

Feel free to experiment with the new resource provider and contact us with questions and comments.

Read more: https://www.dynatrace.com/news/blog/aws-cloudformation-registry/
