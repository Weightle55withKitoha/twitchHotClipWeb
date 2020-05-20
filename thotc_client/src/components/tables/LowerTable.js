import React, { useState } from "react";
import {
  TableRow,
  TableCell,
  TableBody,
  TableContainer,
  Table,
  Typography,
  TablePagination,
} from "@material-ui/core";
import StreamerProfileCol from "./StreamerProfileCol";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  tablecell: {
    width: "12.5%",
  },
}));

function LowerTable(props) {
  const rowCells = props.rowCells;
  let table;

  const classes = useStyles();

  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  function handleChangePage(event, value) {
    setPage(value);
  }

  function handleChangeRowsPerPage(event) {
    setRowsPerPage(event.target.value);
  }

  if (rowCells != null) {
    table = (
      <>
        <TableContainer>
          <Table aria-label="ranking table">
            <TableBody>
              {rowCells
                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                .map((rowCell, index) => (
                  // <Link to={`/profile/${rowCell.streamerName}`} >
                  <TableRow
                    key={rowCell.streamerName}
                    style={
                      index % 2
                        ? { background: "#e2e8f0" }
                        : { background: "white" }
                    }
                  >
                    <TableCell
                      className={classes.tablecell}
                      style={{ fontWeight: "bold", fontSize: "large" }}
                      align="center"
                    >
                      {index + 1}
                    </TableCell>
                    <TableCell className={classes.tablecell} align="center">
                      <StreamerProfileCol
                        ImgUrl={rowCell.streamerImgUrl}
                        StreamerName={rowCell.streamerName}
                      />
                    </TableCell>
                    <TableCell className={classes.tablecell} align="center">
                      {" "}
                    </TableCell>
                    <TableCell
                      className={classes.tablecell}
                      style={{ color: "#d69e2e", fontWeight: "bold" }}
                      align="center"
                    >
                      {rowCell.viewerCount}
                    </TableCell>
                    <TableCell
                      className={classes.tablecell}
                      style={{ color: "#805ad5", fontWeight: "bold" }}
                      align="center"
                    >
                      {rowCell.viewerAverage}
                    </TableCell>
                    <TableCell
                      className={classes.tablecell}
                      style={{ color: "#dd6b20", fontWeight: "bold" }}
                      align="center"
                    >
                      {rowCell.followerCount}
                    </TableCell>
                    <TableCell
                      className={classes.tablecell}
                      style={{ color: "#38a169", fontWeight: "bold" }}
                      align="center"
                    >
                      {rowCell.broadcastTime}
                    </TableCell>
                    <TableCell
                      className={classes.tablecell}
                      style={{ color: "#059bff", fontWeight: "bold" }}
                      align="center"
                    >
                      <div>{rowCell.broadcastEndDay}</div>
                      <div>{rowCell.broadcastEndTime}</div>
                    </TableCell>
                  </TableRow>
                  // </Link>
                ))}
            </TableBody>
          </Table>
        </TableContainer>
        <TablePagination
          className="overflow-hidden"
          component="div"
          count={rowCells.length}
          rowsPerPage={rowsPerPage}
          page={page}
          backIconButtonProps={{
            "aria-label": "Previous Page",
          }}
          nextIconButtonProps={{
            "aria-label": "Next Page",
          }}
          onChangePage={handleChangePage}
          onChangeRowsPerPage={handleChangeRowsPerPage}
          labelRowsPerPage="표시 데이터 수"
        />
      </>
    );
  } else {
    table = (
      <TableContainer>
        <Table aria-label="ranking table">
          <TableBody>
            <TableRow>
              <TableCell>
                <Typography>로그인이 필요합니다.</Typography>
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </TableContainer>
    );
  }
  return table;
}

export default LowerTable;
