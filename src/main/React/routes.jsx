import React from 'react'
import { Route, IndexRoute } from 'react-router'

import {PageWithLeftBarLayout} from 'pages/PageWithLeftBarLayout'

import {ProductsList, EditProduct} from 'pages/products'
import UploadFile from './components/products/UploadFile';

export default (
    <Route name="app" component={PageWithLeftBarLayout} path="/">
        <IndexRoute component={EditProduct}/>
        <Route path="products/new" component={EditProduct}/>
        <Route path="products" component={ProductsList}/>
    </Route>
)