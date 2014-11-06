/**
 * Enabling Chuck Norris plugin on all jobs
 */
def jobs = hudson.model.Hudson.instance.items;
jobs.each { job ->
  Boolean hasChuck = false;         
  for (Iterator publishersItr = job.publishersList.iterator(); publishersItr.hasNext();) {
    def publisher = publishersItr.next();
    if(publisher.getClass().toString().matches(".*CordellWalkerRecorder")){
      hasChuck = true;
      break;
    }
  }
  println job.getFullName() + (hasChuck ? " has chuck" : " has NOT chuck")
  if(! hasChuck){
    println "...adding chuck"
    def walker = new hudson.plugins.chucknorris.CordellWalkerRecorder();
    job.publishersList.add(walker);
  }
}
