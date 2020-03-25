//Jenkin Pipeline code
@Library('jenkins-shared-libraries@master') _
node {
stage('Checkout SCM') {
def SCM_VARS = checkout scm
String GIT_COMMIT = SCM_VARS.GIT_COMMIT
echo GIT_COMMIT
echo env.BUILD_URL
}
// Wrap with the withCredentials
withCredentials(pipelineVariables.call()) {
//withCredentials([[dockerUserName: 'pkuma343'], [dockerPassword: 'Ponkmonk_138202']]) {

stage('Maven Tests') {
try {
//bat curl "https://api.GitHub.com/repos/pkuma343/MySpringBootApp/statuses/${GIT_COMMIT}?access_token=c614fa345a39ae13a2f91b05b81f1f4c576fea66" -H "Content-Type: application/json" -X POST -d "{\"state\": \"success\",\"context\": \"continuous-integration/java/unit-test-execution\", \"description\": \"Jenkins\", \"target_url\": ${env.BUILD_URL}}"
//curl "https://api.github.com/repos/pkuma343/MySpringBootApp/statuses/${GIT_COMMIT}?access_token=4d192260d6530d36d0cfefb0dba341b65ae541b5" -H "Content-Type: application/json" -X POST -d "{\"state\": \"success\",\"context\": \"continuous-integration/java/unit-test-execution\", \"description\": \"Jenkins\", \"target_url\": ${env.BUILD_URL}}"
//bat curl -u "pkuma343:ponkmonk_138202" "https://api.github.com/repos/pkuma343/MySpringBootApp/statuses/3b82e24f80f3e9157ac8643506ab6d512dfa8dda" -H "Content-Type: application/json" -X POST -d "{\"state\": \"success\",\"context\": \"continuous-integration/java/unit-test-execution\", \"description\": \"Jenkins\", \"target_url\": \"http://localhost:9080/job/MyMBProject/job/develop/45/\"}"
bat 'curl -u "'"pkuma343:ponkmonk_138202" "https://api.github.com/repos/pkuma343/MySpringBootApp/statuses/${GIT_COMMIT}"'" -H "Content-Type: application/json" -X POST -d "{\"state\": \"success\",\"context\": \"continuous-integration/java/unit-test-execution\", \"description\": \"Jenkins\", \"target_url\": \"'\"${BUILD_URL}\"'\"}"'
//bat "curl -u 'pkuma343:ponkmonk_138202' 'https://api.github.com/repos/pkuma343/MySpringBootApp/statuses/$GIT_COMMIT' -H 'Content-Type: application/json' -X POST -d '{\"state\": \"success\",\"context\": \"continuous-integration/java/unit-test-execution\", \"description\": \"Jenkins\", \"target_url\": $BUILD_URL}'"
bat 'mvn clean test'; junit '**/surefire-reports/*Test.xml'
} catch(err) {
junit '**/surefire-reports/*Test.xml'//; if(currentBuild.result == 'UNSTABLE') { currentBuild.result = 'FAILURE' }; throw err
}
}
/*stage('Sonar Scan') {
//bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.branch.name=env.BRANCH_NAME'
bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000'
}*/
//stage('Junit step') {
//junit '**/surefire-reports/*Test.xml'
//}
/*
if (!env.CHANGE_TARGET) {
stage('Maven Install') {
bat 'mvn clean install -Dmaven.test.skip=true'
}
stage('Docker build') {
bat 'docker build -t pkuma343/myimage:v1 -f Dockerfile .'
}
stage('Push Image') {
//bat 'docker login -u "pkuma343" -p "Ponkmonk_138202"'
//bat 'docker login -u vars.dockerUserName -p vars.dockerPassword'
bat "docker login -u ${dockerUserName} -p ${dockerPassword}"
bat 'docker push pkuma343/myimage:v1'
}
stage('Openshift Deploy') {
//bat '"C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe" login --token=p-pw_rEzFszNt__4gKxJ5pjFmoiamnWj14OqUzb71g4 --server=https://api.us-west-1.starter.openshift-online.com:6443'
bat "C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe login --token=${ocToken} --server=https://api.us-west-1.starter.openshift-online.com:6443"
bat '"C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe" project my-project-pankaj'
bat '"C:\\Softwares\\openshift-origin-client-tools-v1.5.1-7b451fc-windows\\oc.exe" create -f api.yaml'
}
}
}

stage('Artifactory Deploy') {
def server = Artifactory.server('Artifactory-Server')
def rtMaven = Artifactory.newMavenBuild()
rtMaven.tool = 'Maven-Home'
rtMaven.deployer releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local', server: server
//rtMaven.resolver releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot', server: server
//def buildInfo = rtMaven.run pom: 'pom.xml', goals: "install -Dmaven.test.skip=true -Dbuildnumber=1.0.0"
String command = "clean install -Dmaven.test.skip=true -Dversion=1.0.1"
def buildInfo = rtMaven.run pom: 'pom.xml', goals: command
server.publishBuildInfo buildInfo
}
*/
}
}