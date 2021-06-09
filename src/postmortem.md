# Slutprojekt

Isac Danielsson, 2021-06-01

## Inledning

Målet var att skapa ett snake spel som fungerar som traditionella snake, man ska kunna styra ormen höger, vänster, upp,
ner. Målet är att äta äpplen som spawnar random på spelfältet, när du äter äpplet ska storleken/längden öka med en enhet. 
Du dör/förlorar om du kolliderar med din egen svans eller någon kant på kartan. Jag började kort med att skriva upp klasser för
spelet och sedan började jag göra själva canvasen och skärmen som man spelar på. Sen så gick jag direkt på en metod för att få
äpplena att spawna slumpmässigt på spelfältet.

## Bakgrund

Jag började med att fundera över vilka olika delar som spelet skulle innehålla, där jag bland annat kom fram till 
att spelet behövde ett spelfält, äpplen som ska spawna random på spelfältet, ormen måste vara uppdelad i delar så att man
kan lägga till fler "units" för varje äpple man äter. När jag var klar med det så började jag på en frame där man skulle se
spelet på. Jag behövde sedan en run och stop metod som jag försökte fixa men fick mycket problem med, det fixades när jag 
bytte till magnus metod då den var mycket lättare att förstå och fungerade lättare. Jag behövde göra så att
 äpplerna spawnar slumpmässigt genom att dela upp spelfältet i en osynligt "grid" där äpplerna kan spawna slumpmässigt på.
Jag behövde rita äpplen, ormens huvud och dens kropp delar, kolla så att ormen kolliderar med äpplerna och sin kropp, 
jag skapade därför checkCollision och checkApples för att kunna göra så att spelet känner av ifall detta händer. Jag 
använde mig utav arrayer för att känna av att ormens huvud kolliderar med äpplet för att sedan "incrimenta" både scoret
och ormens längd. Samma med kanterna men när de kolliderar så blir slutar spelet. Sist behövde jag ett score och en game over
screen som jag gjorde med hjälp av draw metoden för att skriva texten. Även if sats för att visa scoren och "game over" när
man förlorar.





Redovisa arbetets olika delar. Så att läsaren förstår vad du gjort och hur.

Använd gärna bilder för att illustrera.

För att lägga till bilder i markdown. Bilderna kan du ladda upp med Git som vanligt, länka dem med url eller filnamnet.

![GitHub Logo](/images/logo.png)
Format: ![Alt Text](url)


![NTI Gymnasiet Umeå Logo](https://raw.githubusercontent.com/jensnti/Webbprojekt/master/mallar/nti_logo_white_umea.svg)

## Positiva erfarenheter

Jag har lärt mig en hel del gällande att skapa ett spel med java, det känns fortfarande väldigt klurigt och det tog lång 
tid för mig att lösa vissa problem som jag hade. Jag känner att jag börjar få kläm på att rita upp grafik med canvas osv. 
Också att använde sig av olika matematiska tecken för att få saker på rätt plats som när jag behövde få ut äpplerna slumpmässigt
på fältet. Jag blev även introduserad till keylistener på ett annat sätt då jag ville att ormen skulle göra 90 graders svängar
vilket blev ett problem. Jag fick även lära mig om metoder för att starta och stoppa spelet och hur de fungerar. Jag har fått 
prova två olika då jag försökte först med en som inte fungerade men sen när jag provade den vi hade lärt oss innan så började
allt fungera. 

## Negativa erfarenheter

Jag har ganska svårt med programmering så det var inte lätt för mig alls, jag hade väldigt många problem som aldrig ville lösas
men tillslut så gick det ju sålklart. Jag hade ett problem där min JFrame inte ville visa sig pågrund av min run method som jag använde.
Det tog lång tid innan jag fick det att fungera dels att märka att jag behövde byta och sen ändra det mesta i min kod för att
passa till den nya run metoden som vi fick lära oss av magnus. 
## Sammanfattning

Jag har lärt mig väldigt mycket under detta projekt gällande java språket, jag är fortfarande inte säker på språket men 
jag är mer säkrare nu än innan projektet började. Det uppstod många problem som jag tillslut lyckades lösa. Spelet blev som jag ville 
förutom att jag inte hade tänkt på att göra något som visar scoret. Jag hade från början tänkt att ormen skulle ha runda kanter men
det blev inte av då jag inte visste hur jag skulle göra. 