import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Paper,
  Container,
  AppBar,
  Typography,
  Box,
  Tabs,
  Tab,
  Grid,
} from "@material-ui/core";
import TableHead from "./UpperTable";
import TableLower from "./LowerTable";
import TableToolbar from "./TableToolbar";

const headCells = [
  { id: "rank", label: "순위", color: "yellow" },
  { id: "streamer", label: "스트리머", color: "yellow" },
  { id: "chatting", label: "실시간채팅", color: "yellow" },
  { id: "viewer", label: "시청자", color: "yellow" },
  { id: "follower", label: "팔로워", color: "yellow" },
  { id: "time", label: "방송시간", color: "yellow" },
  { id: "endBroadCasting", label: "마지막방송", color: "yellow" },
];

function createData(
  number,
  name,
  rowChatting,
  rowViewer,
  rowFollower,
  rowTime,
  rowEndBroadCasting
) {
  return {
    number,
    name,
    rowChatting,
    rowViewer,
    rowFollower,
    rowTime,
    rowEndBroadCasting,
  };
}

const rows = [
  createData(1, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(2, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(3, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(4, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(5, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(6, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(7, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(8, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(9, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(10, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
];

function a11yProps(index) {
  return {
    id: `full-width-tab-${index}`,
    "aria-controls": `full-width-tabpanel-${index}`,
  };
}

const useStyle = makeStyles((theme) => ({
  tab: {
    color: "#e53e3e",
    minWidth: "50px",
    width: "50px",
  },
  indicator: {
    backgroundColor: "white",
  },
}));

const RankingTable = () => {
  const classes = useStyle();
  const [value, setValue] = useState(2);
  const bottomColors = ["#e53e3e", "#d69e2e", "#805ad5", "#dd6b20", "#38a169"];
  const [sstyle,setSstyle] = useState(0);
  const style2 = [
    { background: "#000000", color: "#ffffff" },
    { background: "#ffffff", color: "#000000" },
    { background: "#000000", color: "#ffffff" },
    { background: "#000000", color: "#ffffff" },
    { background: "#000000", color: "#ffffff" },
  ];

  const test = event => {
    console.log("test");
    setSstyle(1);
  };

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Container style={{ marginTop: 50 }} maxWidth="lg">
      <Paper>
        <TableToolbar></TableToolbar>
        <Grid>
          <Tabs
            value={value}
            onChange={handleChange}
            TabIndicatorProps={{
              style: {
                background: bottomColors[value - 2],
                color: "white",
              },
            }}
            variant="fullWidth"
          >
            <Tab label="순위" disabled />
            <Tab label="스트리머" disabled />
            <Tab
              label="실시간 채팅속도"
              color="dark"
              onMouseOver={test}
              style={style2[sstyle]}
              {...a11yProps(0)}
            />
            <Tab
              label="실청자"
              onMouseOver={() => test(1)}
              style={style2[1]}
              {...a11yProps(1)}
            />
            <Tab
              label="팔로워"
              onMouseOver={() => test(2)}
              style={style2[2]}
              {...a11yProps(2)}
            />
            <Tab
              label="방송시간"
              onMouseOver={() => test(3)}
              style={style2[3]}
              {...a11yProps(3)}
            />
            <Tab
              label="마지막방송"
              onMouseOver={() => test(4)}
              style={style2[4]}
              {...a11yProps(4)}
            />
          </Tabs>
        </Grid>
        <TableLower rowCells={rows}></TableLower>
      </Paper>
    </Container>
  );
};

export default RankingTable;
