Chaque test peut être compilé indépendamment, la liste des commandes est la suivante :
- make autobus pour compiler TestAutobus avec le faussaire PassagerStandard
- make passager pour compiler TestPassagerStandard avec le faussaire Autobus
- make jauge pour compiler TestJauge
- make position pour compiler TestPosition
- make simple pour compiler le test d'intégration Simple

Une commande permet de tous les compiler :
- make compil_all

************************************************************
************************************************************

Les commandes suivantes permettent d'éxécuter les tests :
- make test_passager pour éxécuter TestPassagerStandard
- make test_autobus pour éxécuter TestAutobus
- make test_jauge pour éxécuter TestJauge
- make test_position pour éxécuter TestPosition
- make test_simple pour éxécuter Simple

Une commande permet de tous les éxécuter :
- make test_all
