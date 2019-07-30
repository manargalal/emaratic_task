$(document).ready(function () {
    // $('.ag-row-position-absolute').css("transform", "translateY(37px)");
    AOS.init();
    $("body").css("paddingTop", $(".fixd").innerHeight());

    $(".tap-itme").parent().click(function (e) {
        e.preventDefault();
    });


    $(window).scroll(function (){
		if($(window).scrollTop() >= 10) {
        $(".arow2.active:after").hide();

           
			
		} else {
			
		}
	});


    $(".tap-itme:first").addClass("active");
    $(".taps-contant").hide();
    $(".taps-contant:first").show();
    $(".tap-itme").on("click", function () {
        $(".tap-itme").removeClass("active");
        $(this).addClass("active");
        $(".taps-contant").hide();
        $($(this).data("taps")).fadeIn();

    });

    $(".item-req:first").addClass("active");
    $(".request-tap").hide();
    $(".request-tap:first").show();
    $(".item-req").on("click", function () {
        $(".item-req").removeClass("active");
        $(this).addClass("active");
        $(".request-tap").hide();
        $($(this).data("req")).fadeIn();

    });


    $(".tap-tit:first").addClass("active");
    $(".b-tap").hide();
    $(".b-tap:first").show();
    $(".tap-tit").on("click", function () {
        $(".tap-tit").removeClass("active");
        $(this).addClass("active");
        $(".b-tap").hide();
        $($(this).data("form")).fadeIn();

    });

    $(".taps-inven:first").addClass("active");
    $(".inventory-tap").hide();
    $(".inventory-tap:first").show();
    $(".taps-inven").on("click", function () {
        $(".taps-inven").removeClass("active");
        $(this).addClass("active");
        $(".inventory-tap").hide();
        $($(this).data("invent")).fadeIn();

    });



    $(".c-tap:first").addClass("active");
    $(".forms-c-body").hide();
    $(".forms-c-body:first").show();
    $(".c-tap").on("click", function () {
        $(".c-tap").removeClass("active");
        $(this).addClass("active");
        $(".forms-c-body").hide();
        $($(this).data("column")).fadeIn();

    });


    $(".mmission-tap:first").addClass("active");
    $(".mmiss-body").hide();
    $(".mmiss-body:first").show();
    $(".mmission-tap").on("click", function () {
        $(".mmission-tap").removeClass("active");
        $(this).addClass("active");
        $(".mmiss-body").hide();
        $($(this).data("mmission")).fadeIn();

    });



    $(".tap-rules:first").addClass("active");
    $(".rules-tap").hide();
    $(".rules-tap:first").show();
    $(".tap-rules").on("click", function () {
        $(".tap-rules").removeClass("active");
        $(this).addClass("active");
        $(".rules-tap").hide();
        $($(this).data("rules")).fadeIn();

    });


    $(".f-tap:first").addClass("active");
    $(".finantia-taps").hide();
    $(".finantia-taps:first").show();
    $(".f-tap").on("click", function () {
        $(".f-tap").removeClass("active");
        $(this).addClass("active");
        $(".finantia-taps").hide();
        $($(this).data("finantia")).fadeIn();


    });


    $(".tap-manage:first").addClass("active");
    $(".body-lap").hide();
    $(".body-lap:first").show();
    $(".tap-manage").on("click", function () {
        $(".tap-manage").removeClass("active");
        $(this).addClass("active");
        $(".body-lap").hide();
        $($(this).data("lap")).fadeIn();

    });

    $(".item-pharmacy:first").addClass("active");
    $(".pharmacy-taps").hide();
    $(".pharmacy-taps:first").show();
    $(".item-pharmacy").on("click", function () {
        $(".item-pharmacy").removeClass("active");
        $(this).addClass("active");
        $(".pharmacy-taps").hide();
        $($(this).data("phar")).fadeIn();

    });

    $(".item-user:first").addClass("active");
    $(".user-taps").hide();
    $(".user-taps:first").show();
    $(".item-user").on("click", function () {
        $(".item-user").removeClass("active");
        $(this).addClass("active");
        $(".user-taps").hide();
        $($(this).data("user")).fadeIn();

    });


    $(".t-nav-user:first").addClass("active");
    $(".user-body-s").hide();
    $(".user-body-s:first").show();
    $(".t-nav-user").on("click", function () {
        $(".t-nav-user").removeClass("active");
        $(this).addClass("active");
        $(".user-body-s").hide();
        $($(this).data("nav")).fadeIn();

    });





});
