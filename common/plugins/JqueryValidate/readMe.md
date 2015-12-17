# JqueryValidate plugin for Snaphy


###Jquery-Validation to check validation

###This plugin is exposed on  `/jqueryValidate` route


### How to use
```
<form name="schema.form" ng-validate="schema.validations" novalidate  class="form-horizontal">
    <formly-form   model="saveFormData" fields="schema.fields">

    </formly-form>
</form>


<script>

app.controller('test', function(){
    schema.validations = {
        "rules":{
            "username":{
                "required" : true,
                "minlength": "3"
            },
            "password":{
                "required": true,
                "minlength": "5"
            }
        },
        "messages":{
            "username":{
                "required": "Username is required",
                "minlength": "Minimum permitted length is atleast 3"
            },
            "password":{
                    "required": "Password is required",
                    "minlength": "Password must be of atleast 5 characters"
            }
        }
    }
});

</script>

```


####Written by Robins Gupta
