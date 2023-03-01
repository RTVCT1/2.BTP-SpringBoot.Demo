sap.ui.define(["sap/ui/core/mvc/Controller,
				"jquery.sap.global",
				"com/btp/util/service",
				"sap/m/MessageBox"],
				function(Controller,jQuery,service,MessageBox){
	return Controller.extend("com.btp.Controller.Main",{
		onInit: function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"postPayload" : {
					"companyName":"",
					"firstName":"",
					"lastName":"",
					"website":"",
					"email":"",
					"status":"A",
					"gstNo":""
				},
				"vendor" : {}
			});	
			sap.ui.getCore().setModel(oModel);
		}
		onLoadData: function(){
			alert("Will call microservice to Load Vendors Data");
			var that = this;
			service.callService("/newVendor", "GET",{}).then(function(data){
				var oTable = that.getView().byId("idTable");
				var oModel = sap.ui.model.getModel();
				oModel.setProperty("vendor",da
				ta._embedded.vendor);		
				oTable.bindRows("/vendor")
			}).catch(function(oError){
			
			});
		}
		onSave : function(){
			var oModel = sap.ui.model.getModel();
			var oPayload = oModel.getProperty("/postPayload");	
			service.callService("/newVendor","POST",oPayload).then(function(data){
				MessageBox.confirm('Save');						
			}).catch(function(oError){
				MessageBox.error('Not Saved');
			});
		}
	}
});
