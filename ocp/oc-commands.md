# Commands to deploy the hello-world-spring-boot app on Openshift

## Creating a new project
oc new-project myproject --display-name="My Display Name" --description="My description"

## Importing an image from Red Hat registry
oc import-image redhat-openjdk-18/openjdk18-openshift --from=registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:1.8 --confirm -n myproject

## Creating a new build
oc new-build --name=ping-pong --image-stream=openjdk18-openshift:latest --binary -n myproject

## Starting the new build
oc start-build bc/ping-pong --wait --follow --from-file=target/ping-pong.jar -n myproject

## Creating a new app
oc new-app --name=ping-pong --image-stream=ping-pong:latest -n myproject

## Creating ConfigMap
oc create -f ocp/configmap.yaml -n myproject

## Inject ConfigMap content as env-vars in deployment
oc set env deployment/ping-pong --from configmap/ping-pong-config -n myproject

## Inject env-var into deployment
oc set env deployment/ping-pong MATCH_TIME_IN_MINUTES=10 -n myproject
