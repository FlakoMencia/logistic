## MARIO MENCIA - INGENEO TEST

#### 🚧🔨👷 _( THIS PROJECT IS UNDER CONSTRUCTION ...)_   ####  

  * main branch -> INIT PROJECT 
      * dev branch  -> 1.0.0 for release


## Registro de Clientes
(Create, Update, FindByFilters)
```
POST    /api/logistic/client
PATCH   /api/logistic/client/{id}
GET     /api/logistic/client/?params
```

## Gestion de Vehiculos
(findAllAvailable, Create, Dar De Baja)
```
GET     /api/logistic/vehiculo
POST    /api/logistic/vehiculo
PATCH   /api/logistic/vehiculo/{id}
```

## Gestion de Bodegas
(FindAll, Create, EliminateByID)
```
GET     /api/logistic/warehouse
POST    /api/logistic/warehouse
DELETE  /api/logistic/warehouse/{id}
```

## Registro de Puertos
(FindAll, Create, EliminateByID)
```
GET     /api/logistic/seaports
POST    /api/logistic/seaports
DELETE  /api/logistic/seaports/{id}
```



## Security

AUTH:
``` 
    POST /api/authenticate
```
USER LIST (TOKEN ADMIN REQUIERED):
```
    GET /api/ingeneo/admin 
```

REGISTER (NO TOKEN NEED IT):
```
   POST /api/ingeneo/register

Body example:
    {
        "userName"  :"logisticNew01",
        "userEmail" :"iamnew@gmail.com",
        "password"  :"12345"
    }    
```
APPROVE USER (ONLY ADMIN BEARER TOKEN):
```
   PATCH /api/ingeneo/admin/activate/user

Body example:
    {
        "userName"  :"logisticNew01",
    } 
```
DEFAULT USERS:
```
ADMIN: 
    {
        "username": "admin",
        "password": "123"
    }
        
REGULAR USER:
    {
        "username": "logistico01",
        "password": "123"
    }    
```