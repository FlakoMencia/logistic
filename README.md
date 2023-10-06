## MARIO MENCIA - INGENEO TEST


  * main branch -> INIT PROJECT 
      * dev branch  -> 1.0.0 for release



#### 🚧🔨👷 _( THIS PROJECT IS UNDER CONSTRUCTION ...)_   ####  



## Security

```
 AUTH:
  
    POST /api/authenticate
```
```
USER LIST (TOKEN ADMIN REQUIERED):

    GET /api/ingeneo/admin
    
```

```
REGISTER (NO TOKEN NEED IT)
    
   POST /api/ingeneo/register

Body example:
{
    "userName"  :"logisticNew01",
    "userEmail" :"iamnew@gmail.com",
    "password"  :"12345"
}
    
```
```
APPROVE USER (ONLY ADMIN BEARER TOKEN)
    
   PATCH /api/ingeneo/admin/activate/user

Body example:
{
    "userName"  :"logisticNew01",
}
    
```
```
           DEFAULT USERS:

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