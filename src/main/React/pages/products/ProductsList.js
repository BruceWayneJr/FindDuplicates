import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'
import {connect} from 'react-redux'
import * as actionCreators from 'actions/products'

import CustomerTable from 'components/products/CustomerTable'

class ProductsListCmp extends React.Component {
    constructor(props) {
        super(props);
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this);
        this.state = {
            tableNum: 0
          };
    }

    componentDidMount(){
        this.props.loadAllProducts()
    }

    getProducts(){
        if(!this.props.products){
            return []
        }
        return this.props.products
    }
    updateState(){
        this.setState({
            tableNum: this.tableNum.row + 1
        });
    }

    render() {
        return <div className="container-fluid">
            <div className="row">
                <div className="col-md-12">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            {this.getProducts().map(function(product,index) {
                                return(<div>
                                <CustomerTable products={product} key={index} label={index == 0 ? 'Potential Duplicates' : 'None Duplicates'}/>
                                <br/>
                                </div>
                                )}
                            )}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    }
};

function mapStateToProps(state) {
    return {
        needRefresh: state.product.get('needRefresh'),
        products: state.product.get('products')
    }
}

export const ProductsList = connect(mapStateToProps, actionCreators)(ProductsListCmp)