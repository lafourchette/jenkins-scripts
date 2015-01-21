/*
Set log Rotation
*/
def jobs = hudson.model.Hudson.instance.items

println "Setting log rotation for jobs..."
  
jobs.each { job ->
  if (! job.getFullName().matches(".*-pr")) {
    println job.getFullName()
    job.setLogRotator(new hudson.tasks.LogRotator(-1, 30)) // 30 days, 200 builds
    job.logRotate()
  }
}

println "...done"
