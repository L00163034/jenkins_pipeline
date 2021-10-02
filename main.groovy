pipeline {
    agent any
    def template = load("${env.WORKSPACE}/scripts/template.groovy")
    stages {
        stage('doing something') {
            when { expression { 2 > 1 } } // "branch" should work too
            stages {
                stage ('Development') {
                    steps {
                        script {template()}
                    }
                }
                stage ('Staging') {
                    steps {
                        script {template()}
                    }
                }
                stage ('Production') {
                    steps {
                        script {template()}
                    }
                }
            }
        }
    }
}
