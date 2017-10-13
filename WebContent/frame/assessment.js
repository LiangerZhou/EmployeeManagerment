$("select#status").change(function(){
	 var cpname = $(this).val();
	 
	 $.ajax({
    	dataType: "json",
        data: {
       	cpname: cpname,
        },
        type: "post", 
        url: 'task_findByCpname.action?cid=cpname',
        success : function (data) {
        	$(".table1").reload()
       }
   })
});

//导出考核表
function exportE() {
	var str;

	$.ajax({
	    dataType: "json",
	    data: {
	    	stime: stime,
			dtime: dtime,
			Alldays: getAll(stime, dtime),
	    },
	    type: "post", 
	    url: 'task_exportExcel.action',
	    success: function (data) {
	    }
	});
}