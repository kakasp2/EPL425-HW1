````
Στο πρόγραμμα υλοποιήθηκε η επικοινωνία μεταξύ διακομιστή(server) και πελάτη(client).  
Ο server περιμένει κάποιο client να ενωθεί.
Έχουμε N χρήστες που στέλλει πολλά αιτήματα ο καθένας. 
Για κάθε χρήστη εγκαθιδρύεται μια σύνδεση μεταξύ server και client όπου 
ο server στέλνει αιτήματα HELLO και ο client στέλνει WELCOME. 
Επίσης, στο πρόγραμμα υπολογίζεται το RTT (round-trip time) και 
το server throughput. Το αρχείο server.java παίρνει σαν παράμετρο την ip διεύθυνση και το αρχείο user.java παίρνει σαν παράμετρο 
την ip διεύθυνση και port number. 
````

````
Για την εκτέλεση του προγράμματος πρώτα εκτελείται το server.java και μετά εκτελείται το user.java:
java Server ip_address 
java User ip_address port_number

````
