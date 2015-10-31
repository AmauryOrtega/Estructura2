# Estructura2
Tareas pendientes:
- Proyecto cola de priodidad
- Hacer insertar arbol AVL

###Impresiones

- [x] _ColaPrioridad_ String imprimirListaTareas() **Menu**
- [x] _ColaPrioridad_ String imprimirListaTareas(Date f)
- [x] _ColaPrioridad_ String imprimirTarea(String tarea)
	- [x] _ColaPrioridad_  Date buscarTarea(String tarea)
		- [x] _Cola_ boolean buscarTarea(String tarea)

###Insertar

- [x] _ColaPrioridad_ void agregarTarea() throws Exception **Menu1**
	- [x] _ColaPrioridad_ insertarFecha123(Date f)
		- [x] _Cola_ void insertarTarea(String d)
- [x] _ColaPrioridad_ insertarFechaFinal(Date f)
- [x] _ColaPrioridad_ insertarFechaPrincipio(Date f)

###Buscar

- [x] _ColaPrioridad_  Date buscarTarea(String tarea)
	- [x] _Cola_ boolean buscarTarea(String tarea)
- [x] _ColaPrioridad_  NodoPrioridad buscarNodoPrioridad(Date f)

###Borrar

- [x] _ColaPrioridad_ borrarNodoPrioridad(Date f)
	- [x] _ColaPrioridad_  NodoPrioridad buscarNodoPrioridad(Date f)
- [ ] _ColaPrioridad_ void atender()

###Adicionales

- [x] _ColaPrioridad_ void consultarPrimerDato() **Menu2**
	- [x] _ColaPrioridad_ String imprimirTarea(Tarea tarea)
- [ ] _ColaPrioridad_ void actualizarPrimerDato() **Menu3**
	- [ ] _ColaPrioridad_ String imprimirTarea(Tarea tarea)
- [ ] _ColaPrioridad_ void extraerPrimerDato() **Menu4**
	- [ ] _ColaPrioridad_ String imprimirTarea(Tarea tarea)

- [x] _ColaPrioridad_ boolean despuesDe(Tarea uno, Tarea dos)
- [x] _ColaPrioridad_ boolean antesDe(Tarea uno, Tarea dos)
- [x] _ColaPrioridad_ boolean igual(Tarea uno, Tarea dos)

- se debe poder hacer comparaciones por fecha y hora de cada tarea (mayorque, menorque, igual)
+ se dispobe un metodo para leer la fecha y hora y el nombre de la tarea (dentro de agregarTarea)
- otro metodo para mostrar los datos de una tarea (imprimirTarea)
- otro metodo para aplazar una tarea (pendiente aplazar)

- consultar primer dato (mas antiguo) orden de viejo a nuevo (0->inf) (consultarPrimerDato)
- extraer primer dato e insertar con fecha aumentada extraerPrimerDato
- extraer primer dato, no insertarlo, y mostrar su contenido junto a la fecha

arreglando impresion de todas las tareas