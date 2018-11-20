<script type="text/babel">
            var WeatherApp = React.createClass({

                render: function(){
                    return(
                        <h1> Weather </h1>
                        //DayNightRound + Cities 
                    )
                }
            });

            var DayNightRound = React.createClass({
                render:function(){
                    return(
                        //table
                    );
                }
            });

            var City = React.createClass({
                render:function(){
                    return(

                        //tempmin and phenomenon only
                    );
                }
            });

            ReactDOM.render(< WeatherApp /> , document.getElementById("root"));
        