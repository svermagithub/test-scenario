# test-scenarioDescription
Hey there, Gurus! Welcome to this hands-on lab. In this lab, you will first provision an EKS cluster with Terraform. Then, you will deploy an HTML5 web-based Pac-Man game that you can play in your browser to your EKS cluster with Terraform. Sounds like fun!

Objectives
Successfully complete this lab by achieving the following learning objectives:

Deploy Your EKS Cluster with Terraform

In the AWS Management Console, in the IAM service, create an access key for the AWS CLI called Terraform_Access_Key.
In the terminal, configure the AWS CLI to connect to your AWS instance.
Download the EKS Terraform configuration.
Unzip the EKS Terraform configuration zip file.
Change into the eks directory and initialize your working directory.
Deploy your EKS cluster with Terraform. (Note: This can take between 10 and 15 minutes.)
Configure the Kubernetes CLI to use your EKS cluster context.
Confirm your cluster is up and running.
Complete the Terraform Configuration

Download the Pac-Man Terraform configuration.
Unzip the Pac-Man Terraform configuration zip file.
Change into the pac-man directory.
Add the provided Docker image to your Pac-Man deployment configuration.
Update the main Terraform configuration file to include your two modules and pass the pac-man namespace to them.
Save your changes and initialize your pac-man working directory.
Validate your configuration.
Deploy the Pac-Man Web Application with Terraform

Apply the Terraform configuration and deploy the web application in the pac-man namespace.
Confirm that your resources were deployed and are available.
In a browser, launch the application and test that it's working by playing some Pac-Man!
Scale the Kubernetes Web Application

Change the replicas in your deployment configurations to 2 backend pods and 3 frontend pods.
Apply the changes to the Pac-Man web application with Terraform.
Confirm the changes were successfully applied.
In the browser, refresh the application and test that it is still working as expected.
Scale the application back down to 1 backend pod and 1 frontend pod.
Confirm the changes were successfully applied.
In the browser, refresh the application again and test that it is still working as expected.
