L'applicazione sviluppata ricrea l'omonimo gioco da tavolo "Codex Naturalis" permettendo agli utenti di disputare una partita dal loro PC

L'applicazione permette lo svolgimento della partita tramite due modalità di gioco differenti:
1 - Attraverso l'interfaccia grafica (scelta consigliata)
2 - Attraverso l'interfaccia testuale

Come avviare l'applicazione
1 - Primo metodo
    1) Aprire il cmd (Prompt dei Comandi)
    2) Portarsi all'interno della cartella dove è stato salvato il .jar (il file eseguibile)
    3.1) Digitare il seguente comando: java -jar Codex_Naturalis_console.jar , e premere invio
    4.1) Ora potrete scegliere attraverso quale interfaccia disputare la partita *
    3.2) Digitare il seguente comando: java -jar Codex_Naturalis_grafica.jar , e premere invio
    4.2) Ora potrete disputare la partita attraverso l'interfaccia grafica
2 - Secondo metodo (valido solo per giocare tramite interfaccia grafica)
    1) Cliccare 2 volte con il tasto sx del mouse su file denominato "Codex_Naturalis_grafica.jar"
    2) Ora potrete disputare la partita attraverso l'interfaccia grafica
3 - Secondo metodo
    1) Scaricare tutto il file sorgente
    2) Importare il progetto su Eclipse
    3) Nel "Package Explorer" seguire il seguente percorso: Progetto_Codex_Naturalis > src > Logica
    4) Eseguire la classe "CodexNaturalis" contenente il main
    5) Ora potrete scegliere attraverso quale interfaccia disputare la partita

* N.B. Solo per chi volesse svolgere la partita attraverso l'interfaccia testuale,
  per una migliore esperienza di gioco si consiaglia di seguire i seguenti passagi:
  1) Aprire il cmd (Prompt dei Comandi)
  2) Cliccare con il tasto dx del mouse sulla barra bianca posta in cima alla finestra
  3) Cliccare su "Proprietà"
  4) Nella sezione "Dimensione buffer dello schermo" rimuovere la spunta dalla casella "Output di testo a capo in caso di idimensionamento"
  5) Nella medesima sezione impostare la "Larghezza" a 500 (o più)
