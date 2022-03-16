# gateways
2-Modify the sentence spring.datasource.url with the path of war file deployed in the application.PROPERTIES to load the  database file test.

3-Url to access resources:
		
get	"/gateways-0.0.1-SNAPSHOT/gateways"  to list all gateways with their devices.
post 	"/gateways-0.0.1-SNAPSHOT/gateways"  to insert new gateway.
	
get 	"/gateways/{serialNumber}" to get a single gateway.
delete 	"/gateways/{serialNumber}" to delete a gateway.

post 	"/gateways/peripheral" to insert a new device to existing gateway.
delete 	"/gateways/peripheral" to delete a device.
