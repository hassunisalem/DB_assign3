# DB_assign3

## Implementation

The cluster was created and fully operarting when doing the exercise. Data could be written and read in one *Core* and 
read in the two *Replicas* and other *Cores*.

an issue accured when integrating the *Graph-data-Science* plugin to this system. Since the browser did'nt offer any plugin mangement UI
like *Neo4j desktop* dose, i tried just copying the file from the plugin folder, from one of the project folders, to one of the core folders.
As the procdure still was'nt found, i tried connecting one of the cores to the Neo4j desktop app and integrate the plugin there, but then it lost connection to the cluster,
due to some secruty issues, even though the *dbms.security.auth_enabled* was set to false.

During these different approaches, my java aplication could'nt connect to the database anymore. If i had more time, futher development would be to recreate the java aplication
and make all the cores and replicas, from the desktop app, then go inside each file and edit their *neo4j conf. file*
 