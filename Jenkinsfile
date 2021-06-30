pipeline {
    agent any
    tools {
        jdk "jdk11"
        maven "mvn"
    }
    stages {

        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Maven Tests') {
            steps {
                sh 'mvn clean test'
                junit '**/surefire-reports/*Test.xml'
            }
        }

        stage('Sonar Scan') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=demo -Dsonar.host.url=http://ip-172-31-6-130.us-east-2.compute.internal:9000 -Dsonar.login=cb62d433bf1846d579f2879a8f080c77d4755b42'
            }
        }
        
        
        stage('Quality Gate')
         steps {
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
              }
          }

        stage('Maven Install') {
            steps {
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }

        stage('Docker build') {
            steps {
                sh "docker build -t pkuma343/myimage:${env.BUILD_NUMBER} -f Dockerfile ."
            }
        }

        stage('Push Image') {
            steps {
                sh 'docker login -u "pkuma343" -p "Password" || echo "Docker Login Failed"'
                sh "docker push pkuma343/myimage:${env.BUILD_NUMBER} || echo 'Docker Push cannot be done!'"
            }
        }

//        stage('Deploy') {
//            steps{
//                sh 'echo "/path/to/kubectl apply -f api.yaml --kube-config=${PATH_TO_KUBE_CONFIG}"'
//            }
//        }

    }
}
