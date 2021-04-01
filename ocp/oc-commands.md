# Commands to deploy the hello-world-spring-boot app on Openshift

## Creating a new project
oc new-project myproject --display-name="My Display Name" --description="My description"

## Importing an image from Red Hat registry
oc import-image redhat-openjdk-18/openjdk18-openshift --from=registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:1.8 --confirm -n myproject

## Creating a new build
oc new-build --name=hello-world-spring-boot --image-stream=openjdk18-openshift:latest --binary -n myproject

## Starting the new build
oc start-build bc/hello-world-spring-boot --wait --follow --from-file=<path_to_your_jar_or_war_file> -n myproject

## Creating a new app
oc new-app --name=hello-world-spring-boot --image-stream=hello-world-spring-boot:latest -n myproject

## Creating ConfigMap
oc create -f ocp/configmap.yaml -n myproject

## Inject ConfigMap content as env-vars in deployment
oc set env deployment/hello-world-spring-boot --from configmap/ping-pong-config -n myproject

## Inject env-var into deployment
oc set env deployment/hello-world-spring-boot MATCH_TIME_IN_MINUTES=10 -n myproject
