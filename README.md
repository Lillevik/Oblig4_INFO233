# Oblig4_INFO233

Info233 - Avansert Programmering, våren 2016
Obligatorisk oppgave: #4 av 4
Innleveringsfrist: Fredag 13. mai kl. 14.00
Format: .zip arkivfil
Filnavn: brukernavn1_brukernavn2_oblig4.zip
Prosjektnavn: no.uib.info233.v2016.<brukernavn1_brukernavn2>.oblig4
Om obligatoriske oppgaver

I de obligatoriske oppgavene stilles det en rekke krav. Disse må tilfredsstilles for å få
godkjent oppgaven. Les oppgaven nøye.
Hvis teksten er uklar eller du mener det finnes flere tolkninger av et krav, vennligst
kontakt en undervisningsassistent for å få en presisering (epostlenker finnes på MiSide).
Hvis dere får “ikke godkjent”, får dere anledning til å levere en egenretting kort tid
etter. Dere vil uansett få tilbakemelding på innleveringene deres.
Når dere skal levere, må hele prosjektmappen arkiveres i en .zip fil. Oppgavene leveres
på MiSide i den relevante mappen.
Obligatoriske oppgaver 2-4 skal løses i grupper på 2.

Oppgaven
I denne oppgaven skal dere utvikle en applikasjon som opererer på en ekstern database
som ligger på serveren bigfoot.uib.no. For å få tilgang til databasen må dere sende en
epost med navn på begge gruppemedlemmene til enten Sigve eller Ole Andreas som så
vil sende dere påloggingsinformasjon.
Selve databasestrukturen blir ikke så komplisert, siden hovedpoenget med oppgaven er
at dere skal dokumentere at dere klarer å sette opp strukturen i databasen, legge inn og
endre data i databasen fra en ekstern klient, og vise data som ligger i databasen i
klienten (dvs program på en lokal maskin).
Business Case
En høyskole ønsker et program for å administrere karaktersetting av kurs. Programmet
må holde oversikt over hvilke studenter som tar kurset, et kurs skal kunne bestå av ulike
deler som skal karaktersettes, og de ulike delene av kurset skal kunne vektes ulikt.
Målet er at endelig karakter skal beregnes ut fra vektingen av de ulike delene. Det er
viktig at en skal kunne legge inn karakter for ulike deler separat, og først når alle delene
er lagt inn, vil en endelig karakter bestemmes. Løsningen må lages så fleksibelt at noen
deler kan være gjort sammen av en gruppe studenter, og her må det gå an å
karaktersette dette felles for studentene som har deltatt på dette, f.eks. å skrive en
artikkel.
Dere skal lage en prototype som lager en løsning for ett kurs, hvor den kursansvarlige
må definere hvilke deler av kurset som skal karaktersettes, og hvordan vektleggingen av
de ulike delene skal være.
Krav
1. Kursansvarlig skal kunne legge inn navn på kurs, hvilke deler kurset skal bestå av
(disse skal kunne gis navn), og hvordan de ulike delene av kurset skal vektes for
karaktersetting (vekting kan være fra 20% av totalkarakteren og oppover).
Summen av vektinger må være 100%. Disse verdiene skal brukes senere når
karakterene beregnes.
2. Det skal kunne legges inn en liste over studenter. Dette kan enten gjøres av
brukeren via brukergrensesnittet eller ved å importere en sql-fil som inneholder
alle kursdeltakerne.
3. Når kurset (eller en del av kurset) skal karaktersettes, skal en kunne legge inn
delkarakterer for en del av kurset, f.eks. Prosjektarbeid. Dette kan gjøres enten
ved at du velger en enkelt student om gangen, eller ved at du har en liste over
studenter og kan legge karakterene direkte inn i relevante celler i en tabell.
4. Det skal brukes bokstavkarakterer: A - F.
5. Det er ønskelig at det blir indikert hvilke karakterer som mangler, og/eller hvor
stor andel av delkarakterene som er satt.
6. Når alle karakterene for en student er lagt inn, skal det regnes ut en endelig
karakter for vedkommende.
7. Det er ønskelig at kursansvarlig skal kunne sortere studentene på bakgrunn av
navn, delkarakter på en enkel kursdel eller totalkarakter.
8. Siden det potensielt skal kunne være mange studenter som tar et kurs, skal en
også kunne søke etter en bestemt student basert på navn.
9. Som en ekstraoppgave kan dere lage en tabell som viser karakterfordelingen.
10. Dere skal også lage noen enhetstester. Dette kan f.eks. være:
a. Test for oppkobling mot databasetjeneren.
b. Et sett av tester for beregning av endelig karakter. Husk
avrundingsproblematikken.
c. Testing på innsetting av verdier som er feil. (Bokstaver utenfor
karakterskala eller navn bestående av nummer eller ugyldige tegn)
Tips​: Det kan være lurt å begynne med å lage et utkast til databasestruktur slik at en ser
at en får med seg alle detaljene. Hvilke tabeller trenges og hva slags datatyper skal en
bruke til de ulike kolonnene.
Når en utvikler et program iterativt, er det lurt å implementere deler av programmet og
kun legge inn den delen av databasen som er nødvendig til akkurat disse delene av
programmet. Dette for at en ikke skal måtte gjøre arbeid om igjen hvis en gjør en feil i
design.
Databasen kan designes via https://bigfoot.uib.no/phpMyAdmin/. Oppgi det
brukernavn/passord dere fikk oppgitt til databasen. Herfra kan tabellene legges inn via
grensesnittet, eller en sql-fil som inneholder spesifikasjonen for tabellene kan lastes
opp.
Som i de foregående obligatoriske oppgavene så skal alle klasser og metoder være godt
kommenterte og i henhold til Javadoc, dvs. klassekommentarer skal ha forfatternavn for
alle gruppedeltagerne.
Følg prinsipper for god objektorientert design hvor hver klasse har ansvar for en ting og
hver metode gjør kun en ting. Unngå unødvendig kobling mellom klassene.
Klasser, variabler og parameter skal ha navn som er meningsfulle. Klassene skal også
organiseres i pakker med fullstendige pakkenavn (som vil si, invers uri navn).
Innleveringen av prosjektet skal inkludere hele mappen med kildekode i tillegg til en
kjørbar .jar fil av programmene. Hvis dere har lastet inn sql-filer, skal disse være med
også.
Lykke til!
