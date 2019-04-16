import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'
import { Link } from 'react-router'


export default class SideBar extends React.Component {
    constructor(props) {
        super(props)
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this)
    }

    render() {
        return     <div className="sidebar" data-color="purple">

            <div className="sidebar-wrapper">
                <div className="logo">
                    <Link to="/" className="simple-text">
                        MENU
                    </Link>
                </div>

                <ul className="nav">
                    <li>
                        <Link to="/products/new">
                            <i className="pe-7s-ribbon"></i>
                            Upload File
                        </Link>
                    </li>
                    <li>
                        <Link to="/products">
                            <i className="pe-7s-ribbon"></i>
                            Show results
                        </Link>
                    </li>
                </ul>
            </div>
        </div>

    }
}
