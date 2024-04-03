DB credentials stored into resources.xml.

Schema name: productsurvey (mysql://localhost:3306/productsurvey)
"create schema" command is already included in "self-contained" dump.

Sample data into "dirty" db dump:

"Simple" Users:
username: user1 password: user1
username: user2 password: user2
username: user3 password: user3
username: user4 password: user4, BANNED!

Administrators:
username: admin1 password: admin1
username: admin2 password: admin2

Offensive words:
ignobile, inetto, maleducato, malfattore, provocatore, zitto

Products:
4 products with related reviews:
Zaffiro, Scirocco, Vento, Maestrale

Questionnaires:
There are questionnaires for several weeks from now on (17-05-2021 until 4-06-2021) but only questionnaires of 17-05-2021 and 18-05-2021 have user responses. They can be seen by logging as an administrator and looking up these dates.
In particular, user1 and user2 have answered to 17-05-2021 questionnaire, user3 has only opened it.
Only user1 has answered to 18-05-2021 questionnaire, nobody else opened it.