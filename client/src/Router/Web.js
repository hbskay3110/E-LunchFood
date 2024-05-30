import { createBrowserRouter } from "react-router-dom";
import Home from "../Component/Home";
import ProductList from "../Component/ProductList";
import App from "../App";
import ProductDetail from "../Component/Product-detail";
import Login from "../Component/Login";
import Register from "../Component/Register";
import Cart from "../Component/Cart"
<<<<<<< HEAD
import Account from "../Component/Account";    
=======
import Checkout from "../Component/Checkout"
import OrderDetail from "../Component/OrderDetail";
>>>>>>> 9d021c10219d264beaddb66c93fbe38cedc9e99b

export const  webRouter = createBrowserRouter([{
    path:'/',
    element:<App/>,
    children:[
        {
            path:"/",
            element:<Home/>
        },
        {
            path:"/login",
            element:<Login/>
        },
        {
            path:"/register",
            element:<Register/>
        }
        ,{
            path:"/listProduct",
            element:<ProductList/>
        },
        {
            path:'/product/:idProduct',
            element:<ProductDetail/>,
        },
        {
            path:'/checkout',
            element:<Checkout/>,
        },
        {
            path:'/cart',
            element:<Cart/>
        },
        {
<<<<<<< HEAD
            path:'/account',
            element:<Account/>,
        }
    ]
=======
            path:'/orderDetail/:id',
            element:<OrderDetail/>,
        }]

>>>>>>> 9d021c10219d264beaddb66c93fbe38cedc9e99b
}])