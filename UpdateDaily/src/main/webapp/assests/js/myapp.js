$(function() {
	
	// for adding a loader
	$(window).load(function(){
		setTimeout(function() {
			$(".se-pre-con").fadeOut("slow");
		}, 500);			
	});	
	

	
	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
	case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;		
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

/*	var products=[
		["1","abc"],
		
		["2","abc"],
		["3","abc"],
		["4","abc"],
		["5","abc"],
		["6","abc"],
		["7","abc"],
		["8","abc"],
		["9","abc"],
		["10","abc"],
		["11","abc"],
		["12","abc"]
		
	];*/
		
	// code for jquery dataTable
	var $table = $('#productList');
	 var jsonUrl='';
	 if(window.categoryId == '')
		 {
		 jsonUrl= window.contextRoot + '/json/data/all/products';
		 }
	 else
		 {
		 jsonUrl=window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		 }
	
	
	$table.DataTable({
		
		lengthMenu:[[3,5,10,-1],['3 record', '5 record', '10 recored','All']],
		pageLength:5,
	/*	data:products*/
		ajax:{
			url:jsonUrl,
			dataSrc:''
				
		},
		
		columns:[
			{
				data:'code',
				mRender: function(data,type,row)
				{
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg"  style="height:100px;width:100px"/>';
				}
				
				
			},
			
			
			{
				data:'name'
				
				
			},
			
			{
				data:'brand'
				
				
			},
			
			{
				data:'unitPrice',
				mRender:function(data,type,row)
				{
					return '&#8377; ' +data;
				}
				
				
			},
			{
				data:'quantity'
				
				
			},
			{
				bSortable: false,
				data:'id',
				mRender: function(data,type,row)
				{
					var str='';
					str+='<a href=" '+window.contextRoot+'/show/'+data+'/product " class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&#160';
					
					str+='<a href=" '+window.contextRoot+'/cart/add/'+data+'/product " class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					return str;
				}
				
				
			}
		]
		
	});
});	

