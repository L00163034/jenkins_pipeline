pipeline {
    agent any
    def template = load("${env.WORKSPACE}/scripts/template.groovy")
    stages {
        stage('doing something') {
            when { expression { 2 > 1 } } // "branch" should work too
            stages {
                stage ('a') {
                    steps {
                        script {echo "a"}
                    }
                }
                stage ('b') {
                    steps {
                        script {echo "b"}
                    }
                }
                stage ('c') {
                    steps {
                        script {echo "c"}
                    }
                }
            }
        }
    }
}
