# cocus-challenge

This REST API exposes a single endpoint to play the game of FizzBuzz.
It has been developing using Java.

#### Dependencies
* [Maven](https://maven.apache.org/download.cgi)
* [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)
* [Elastic Beanstalk CLI](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3.html)


#### AWS credentials
Set the AWS credentials (usually `~/.aws/credentials`)
You can set AWS credentials through aws cli

```shell
aws configure
```

## Deploy the code on AWS

To deploy the code on AWS, you have to install elastic beanstalk cli 

```shell
mvn package && eb create fizzbuzz-cocus-challenge
```

## Deploy the infrastructure

After the full provisioning of AWS infrastructure, 
to provision the API Gateway you have to: 

- Get Load Balancer DNS and put it in /infrastructure/params.json file
- Run the command below

```shell
aws cloudformation create-stack --stack-name fizzbuzz-cocus-dev --parameters file://infrastructure/params.json --template-body file://infrastructure/infrastructure.yaml
```

## Running the code

You have two options to run the code.

- Locally
- Deploy it in AWS cloud using elastic beanstalk

## Infrastructure as code

CloudFormation template for provisioning AWS infrastructure
is located into folder /infrastructure  

The following infrastructure components are in CloudFormation template

- AWS API Gateway

## REST API Documentation

You will be able to reach Swagger documentation accessing the following link below
- http://loalhost:5000/swagger-ui.html
