import React from 'react';
import PureRenderMixin from 'react-addons-pure-render-mixin';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import InputLabel from '@material-ui/core/InputLabel';

var root = {
    width: '100%',
    overflowX: 'auto',
    };

var table = {
    minWidth: 700,
    };

export default class CustomerTable extends React.Component {
    constructor(props) {
        super(props)
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this)
    }
    
    getProducts(){
        if(!this.props.products){
            return []
        }
        return this.props.products
    }

    csvToArray(text) {
        let ret = [''], i = 0, p = '', s = true;
        for (let l in text) {
            l = text[l];
            if ('"' === l) {
                s = !s;
                if ('"' === p) {
                    ret[i] += '"';
                    l = '-';
                } else if ('' === p)
                    l = '-';
            } else if (s && ',' === l)
                l = ret[++i] = '';
            else
                ret[i] += l;
            p = l;
        }
        return ret;
    }    

    render() {
        return(
    <div>
        <InputLabel>{this.props.label}</InputLabel>
        <Paper style={root}>
            <Table style={table}>
                <TableHead>
                <TableRow>
                    <TableCell >ID</TableCell>
                    <TableCell align="right">First Name</TableCell>
                    <TableCell align="right">Last Name</TableCell>
                    <TableCell align="right">Company</TableCell>
                    <TableCell align="right">Email</TableCell>
                    <TableCell align="right">Address1</TableCell>
                    <TableCell align="right">Address2</TableCell>
                    <TableCell align="right">Zip</TableCell>
                    <TableCell align="right">City</TableCell>
                    <TableCell align="right">State(Long)</TableCell>
                    <TableCell align="right">State</TableCell>
                    <TableCell align="right">Phone</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {this.getProducts().map(row => (
                    <TableRow key={row}>
                    {this.csvToArray(row).map(entry => (
                        <TableCell align="right">{entry}</TableCell>
                    ))}
                    </TableRow>
                ))}
                </TableBody>
            </Table>
        </Paper>
    </div>
        )
    }
}
