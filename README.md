<h2> Architecture hexagonale - Spring Boot  </h2>

<h3> Présentation </h3>

L'architecture hexagonale, également connue sous le nom de <b> "Port and Adapter"</b>, est un style d'architecture logicielle qui vise à créer des systèmes modulaires, flexibles et indépendants des détails d'implémentation. Cette approche est souvent utilisée dans le développement de logiciels orientés vers le domaine (domain-driven design).</br>

L'architecture hexagonale peut être décomposée en trois parties principales :<b> application, domaine et infrastructure.</b></br>

<h4> Application </h4></br>
- C'est la couche où les cas d'utilisation de l'application sont mis en œuvre.</br>
- Elle comprend les services, les gestionnaires d'événements, les contrôleurs, etc.</br>
- Cette couche réagit aux entrées utilisateur, invoque des opérations sur le domaine, et gère les transactions et la coordination des opérations.</br>

<h4> Domaine </h4></br>
- C'est le cœur de l'application, où réside la logique métier.</br>
- Il comprend les entités, les agrégats, les services de domaine et les règles métier.</br>
- Cette couche est indépendante des détails de la mise en œuvre et doit être agnostique vis-à-vis de la technologie utilisée.</br>

<h4> Infrastructure </h4>
- C'est le cœur de l'application, où réside la logique métier.</br>
- Il comprend les entités, les agrégats, les services de domaine et les règles métier.</br>
- Cette couche est indépendante des détails de la mise en œuvre et doit être agnostique vis-à-vis de la technologie utilisée.</br>

<img src="https://github.com/Zaghdoudii/hexagonal-architecture/hexagonal-arch.png" width="250">

L'idée principale de l'architecture hexagonale est de maintenir la séparation des préoccupations entre ces trois couches, avec la couche du domaine au centre, entourée par les couches d'application et d'infrastructure. Cette séparation permet une plus grande flexibilité et facilite le remplacement ou la mise à niveau de composants sans affecter les autres parties du système.




