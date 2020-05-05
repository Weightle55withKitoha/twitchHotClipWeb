import React from "react";
import {
  TableRow,
  TableCell,
  TableBody,
  TableContainer,
  Table,
  Typography
} from "@material-ui/core";
import StreamerProfileCol from './StreamerProfileCol';
import {makeStyles} from '@material-ui/core/styles';

const useStyles = makeStyles(theme=>({
  tablecell : {
    width : '12.5%'
  }
}));

function LowerTable(props) {
  const rowCells = props.rowCells;
  let table;

  const classes = useStyles();

  if (rowCells != null) {
    table = (
      <TableBody>
        {rowCells.map((rowCell, index) => (
          <TableRow
            key={rowCell.streamerName}
            style={
              index % 2 ? { background: "#e2e8f0" } : { background: "white" }
            }
          >
            <TableCell className={classes.tablecell} style={{fontWeight:'bold',fontSize:'large'}} align="center">{index + 1}</TableCell>
          <TableCell className={classes.tablecell} align="center"><StreamerProfileCol ImgUrl={rowCell.streamerImgUrl} StreamerName={rowCell.streamerName}/></TableCell>
          <TableCell className={classes.tablecell} align="center"> </TableCell>
            <TableCell className={classes.tablecell} style={{color:"#d69e2e",fontWeight:'bold'}} align="center">{rowCell.viewerCount}</TableCell>
            <TableCell className={classes.tablecell} style={{color:"#805ad5",fontWeight:'bold'}} align="center">{rowCell.viewerAverage}</TableCell>
            <TableCell className={classes.tablecell} style={{color:"#dd6b20",fontWeight:'bold'}} align="center">{rowCell.followerCount}</TableCell>
            <TableCell className={classes.tablecell} style={{color:"#38a169",fontWeight:'bold'}} align="center">{rowCell.broadcastTime}</TableCell>
            <TableCell className={classes.tablecell} style={{color:"#059bff",fontWeight:'bold'}} align="center"><div>{rowCell.broadcastEndDay}</div><div>{rowCell.broadcastEndTime}</div></TableCell>
          </TableRow>
        ))}
      </TableBody>
    );
  } else {
    table = (
      <TableBody>
        <TableRow>
          <TableCell>
            <Typography>로그인이 필요합니다.</Typography>
          </TableCell>
        </TableRow>
      </TableBody>
    );
  }
  return (
    <TableContainer>
      <Table aria-label="ranking table">{table}</Table>
    </TableContainer>
  );
}

export default LowerTable;
