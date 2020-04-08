import {createMuiTheme} from "@material-ui/core/styles";

//테마 color
const theme = createMuiTheme({
    palette : {
        primary: {
            main : '#ffffff',
        },
        secondary: {
            light: '#00ffff',
            main: '#ffffff',
        }
    },
    //스페이싱 배열
    spacing : [0,2,4,8] 
});



export default theme;